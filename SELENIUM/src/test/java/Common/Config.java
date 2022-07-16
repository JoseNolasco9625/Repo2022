package Common;

import java.io.File;

public class Config
{
    public static String URL_QA = "http://automationpractice.com/index.php/";
    public static String URL_DEV = "http://automationpractice.com/index.php/";
    public static String AMZ = "https://www.amazon.com.mx/";
    public static String URL_DRAG_AND_DROP ="https://jqueryui.com/droppable/";
    public static String URL_FILE_UPLOAD = ARCHIVOS_DIR() + "upload_file.html";
    public static String URL_Fatima = "https://test.embajadoreshircasa.com:52443/LoginMaster";


    public static String user = "test.0@test.com";
    public static String pwd = "test1234";

    public static String user_Embajador = "cortiz@hircasa.com,";
    public static String pwd_Embajador="Hircasa123.";


    public static String ARCHIVOS_DIR()
    {
        return System.getProperty("user.dir")
                +File.separator
                + "Files"
                + File.separator;
    }

}
