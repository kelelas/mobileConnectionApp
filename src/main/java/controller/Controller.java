package controller;

import model.*;
import view.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static java.util.Comparator.comparing;


/**
 * Created on 16.02.2020
 * @author Vladyslav Osypchuk
 * @version 2.1
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
        fillArray();
        view.setLocale(inputLanguageInfo(sc));
        choseOperation(sc);
    }
    public void fillArray(){
        model.addTariff(TariffEnum.BOMB);
        model.addTariff(TariffEnum.LIFEHACK);
        model.addTariff(TariffEnum.PLATINUM);
        model.addTariff(TariffEnum.PREMIUM);
        model.addTariff(TariffEnum.SMARTFAMILY);
        model.addTariff(TariffEnum.HEAT);
        model.addTariff(TariffEnum.FORBUSSINES);
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
    int i=0;


    while (i < 1 || i >6) {
        i = Integer.parseInt(inputValueWithScanner(scanner, TextConstant.INPUT_STRING_DATA, Regex.REGEX_ONE_NUMBER));
        view.printMessage(TextConstant.INPUT_DIVIDER);
    }
    switch (i) {
        case (1):
            view.printMessage(TextConstant.INPUT_LIST_OF_TARIFFS);
            for (TariffEnum tariffEnum : model.getTariffs()) {
                view.print(tariffEnum.toString());
            }
            break;
        case (2):
            view.printMessage(TextConstant.INPUT_LIST_OF_SORTED_TARIFFS);
            for (TariffEnum tariffEnum : sortTariffList(model.getTariffs())) {
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
    public List<TariffEnum> sortTariffList(List<TariffEnum> tariffEnums){
        List<TariffEnum> list = new ArrayList<>(tariffEnums);
        list.sort(comparing(TariffEnum::getTariffCost));
        return list;
    }
    public List<TariffEnum> findTariffByParam(Scanner scanner){
        int i = 0;
        while (i < 1 || i > 5) {
            i = Integer.parseInt(inputValueWithScanner(scanner, TextConstant.INPUT_CHOSE_PARAMS, Regex.REGEX_ONE_NUMBER));
        }
        int min;
        switch (i){
            case (1):

                model.setSortTariffs(TariffSearcher.findTariffsByTariffCost(min = minValue(scanner), maxValue(min, scanner)));
                view.printMessage(TextConstant.INPUT_DIVIDER);
                view.printMessage(TextConstant.INPUT_LIST_OF_TARIFFS);
                break;
            case (2):
                model.setSortTariffs(TariffSearcher.findTariffsByMinutesCount(min = minValue(scanner), maxValue(min, scanner)));
                view.printMessage(TextConstant.INPUT_DIVIDER);
                view.printMessage(TextConstant.INPUT_LIST_OF_TARIFFS);
                break;
            case(3):

                model.setSortTariffs(TariffSearcher.findTariffsByMassageCount(min = minValue(scanner), maxValue(min, scanner)));
                view.printMessage(TextConstant.INPUT_DIVIDER);
                view.printMessage(TextConstant.INPUT_LIST_OF_TARIFFS);
                break;
            case (4):

                model.setSortTariffs(TariffSearcher.findTariffsByInternetCount(min = minValue(scanner), maxValue(min, scanner)));
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
