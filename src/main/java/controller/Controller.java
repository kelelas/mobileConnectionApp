package controller;

import model.*;
import view.*;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;



/**
 * Created on 16.02.2020
 * @author Vladyslav Osypchuk
 * @version 3.2
 */
public class Controller {
    private Model model;
    private View view;
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        model.fillArray();
        view.setLocale(inputLanguageInfo(sc));
        choseOperation(sc);
    }

    public  Locale inputLanguageInfo(Scanner scanner){
        int i = 0;
        while (i < 1 || i > 3) {
            i = Integer.parseInt(inputValueWithScanner(scanner, TextConstant.INPUT_LANGUAGE, Regex.REGEX_NUMBER));
        }
        if (i == 1){
            return new Locale("en");
        }else
            return new Locale("ua", "UA");
    }
    public void choseOperation(Scanner scanner){

outer : while (true) {
    view.printMessage(TextConstant.INPUT_DIVIDER);
    int operationNumber=0;


    while (operationNumber < 1 || operationNumber >6) {
        operationNumber = Integer.parseInt(inputValueWithScanner(scanner, TextConstant.INPUT_STRING_DATA, Regex.REGEX_ONE_NUMBER));
        view.printMessage(TextConstant.INPUT_DIVIDER);
    }
    switch (operationNumber) {
        case (1):
            view.printMessage(TextConstant.INPUT_LIST_OF_TARIFFS);
            for (TariffEnum tariffEnum : model.getTariffs()) {
                view.print(tariffEnum.toString());
            }
            break;
        case (2):
            view.printMessage(TextConstant.INPUT_LIST_OF_SORTED_TARIFFS);
            for (TariffEnum tariffEnum : model.sortTariffList(model.getTariffs())) {
                view.print(tariffEnum.toString());
            }
            break;
        case (3):
            view.printMessage(TextConstant.INPUT_AMOUNT_OF_USERS);
            view.print(String.valueOf(TariffEnum.allClientCount()));
            break;
        case (4):
            for (TariffEnum tariffEnum : findTariffByParam(scanner)) {
                view.print(tariffEnum.toString());
            }
            break;
        case (5):

            break outer;
    }
}
    }
    public String inputValueWithScanner(Scanner scanner, String message, String regex){
        String res;
        view.printMessage(message);
        while( !(scanner.hasNext() && (res = scanner.next()).matches(regex))) {
            view.printMessage(TextConstant.INPUT_ERROR);
        }
        return res;
    }

    public List<TariffEnum> findTariffByParam(Scanner scanner){
        int operationNumber = 0;
        while (operationNumber < 1 || operationNumber > 5) {
            operationNumber = Integer.parseInt(inputValueWithScanner(scanner, TextConstant.INPUT_CHOSE_PARAMS, Regex.REGEX_ONE_NUMBER));
        }
        int min;
        switch (operationNumber){
            case (1):

                model.setSortTariffs(model.findTariffsByTariffCost(min = minValue(scanner), maxValue(min, scanner)));
                view.printMessage(TextConstant.INPUT_DIVIDER);
                view.printMessage(TextConstant.INPUT_LIST_OF_TARIFFS);
                break;
            case (2):
                model.setSortTariffs(model.findTariffsByMinutesCount(min = minValue(scanner), maxValue(min, scanner)));
                view.printMessage(TextConstant.INPUT_DIVIDER);
                view.printMessage(TextConstant.INPUT_LIST_OF_TARIFFS);
                break;
            case(3):

                model.setSortTariffs(model.findTariffsByMassageCount(min = minValue(scanner), maxValue(min, scanner)));
                view.printMessage(TextConstant.INPUT_DIVIDER);
                view.printMessage(TextConstant.INPUT_LIST_OF_TARIFFS);
                break;
            case (4):

                model.setSortTariffs(model.findTariffsByInternetCount(min = minValue(scanner), maxValue(min, scanner)));
                view.printMessage(TextConstant.INPUT_DIVIDER);
                view.printMessage(TextConstant.INPUT_LIST_OF_TARIFFS);
                break;
            case (5):
                break;
        }
        return model.getSortTariffs();
    }
    private int minValue(Scanner scanner){
        int min= 0;
        while (min < 1 || min > 20000) {
            min = Integer.parseInt(inputValueWithScanner(scanner, TextConstant.INPUT_MIN, Regex.REGEX_NUMBER));
            if (min < 1 || min > 20000)
                view.printMessage(TextConstant.INPUT_ERROR_OF_BOUND);
        }

       return min;
    }
    private int maxValue(int min, Scanner scanner){
        int max = 0;
        while (max < 1 || max > 20000) {
            max = Integer.parseInt(inputValueWithScanner(scanner, TextConstant.INPUT_MAX, Regex.REGEX_NUMBER));
            if(max < min || max > 20000)
                view.printMessage(TextConstant.INPUT_ERROR_OF_BOUND);
        }
        return max;
    }

}
