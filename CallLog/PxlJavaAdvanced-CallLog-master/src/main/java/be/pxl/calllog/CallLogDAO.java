package be.pxl.calllog;

import java.sql.*;
import java.util.Collection;

/**
 * Created by tim_v on 21/03/2017.
 */
public class CallLogDAO {
    // vars
    private String _url;
    private String _user;
    private String _passwd;

    public CallLogDAO(String url, String user, String passwd){
        _url = url;
        _user = user;
        _passwd = passwd;
    }



    public void insertCallLogList(Collection<CallLog> callLogList) {
        try(Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO `calllog` (`Id`, `Name`, `Date`, `Company`, `Description`, `Priority`, `Status`) VALUES (?,?,?,?,?,?,?)")){
            System.out.println("Start upload into DB");
            for(CallLog callLog: callLogList){
                stmt.setInt(1, callLog.getId());
                stmt.setString(2, callLog.getNaam());
                stmt.setDate(3, new java.sql.Date(callLog.getDatum().getTime()));
                stmt.setString(4, callLog.getBedrijf());
                stmt.setString(5, callLog.getOmschrijving());
                stmt.setInt(6, callLog.getPrio());
                stmt.setString(7, String.valueOf(callLog.getStatus()));
                stmt.executeUpdate();
                // System.out.println("Updated log: " + callLog.getId());
            }
            System.out.println("End upload into DB");
        }
        catch (SQLException sqlE){
            sqlE.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(_url, _user, _passwd);
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }

    public String get_user() {
        return _user;
    }

    public void set_user(String _user) {
        this._user = _user;
    }

    public String get_passwd() {
        return _passwd;
    }

    public void set_passwd(String _passwd) {
        this._passwd = _passwd;
    }
}
