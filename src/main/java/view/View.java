package view;

import controller.Controller;
import controller.InputUserInfo;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import static view.TextConstant.*;

/**
 * Created on 16.02.2020
 * @author Vladyslav Osypchuk
 * @version 1.1
 */
public class View {

    //Locale locale= new Locale("ua", "UA");
    Locale locale = new Locale("en");
    public ResourceBundle bundle =
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
}
