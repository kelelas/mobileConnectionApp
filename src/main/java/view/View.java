package view;

import java.util.Locale;
import java.util.ResourceBundle;

import static view.TextConstant.*;

/**
 * Created on 16.02.2020
 * @author Vladyslav Osypchuk
 * @version 2.1
 */
public class View {

    //Locale locale= new Locale("ua", "UA");
    private Locale locale = new Locale("en");
    private ResourceBundle bundle =
            ResourceBundle.getBundle(
                    "text", locale);

    public void printMessage(String message){
        System.out.println(bundle.getString(message));
    }
    public void print(String message){
        System.out.println(message);
    }
    public void printStringInput() {
        printMessage(bundle.getString(INPUT_STRING_DATA));
    }
    public void setLocale(Locale locale){
        this.bundle = ResourceBundle.getBundle(
                "text", locale);
    }
}
