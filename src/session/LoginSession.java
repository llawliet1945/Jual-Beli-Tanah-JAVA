package session;

/**
 * @author Vena Grasheela
 */
public class LoginSession {
    private static String ven;
    public static void setUserLogin(String id){
        ven=id;   
    }
    public static String getUserLogin(){
        return ven;
    }
}
