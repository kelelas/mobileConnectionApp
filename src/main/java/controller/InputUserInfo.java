package controller;

import model.Model;
import model.TariffEnum;
import view.TextConstant;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static java.util.Comparator.comparing;

public class InputUserInfo {
    private View view;
    private Model model;
    Scanner sc = new Scanner(System.in);
    TariffSearcher tariffSearcher = new  TariffSearcher();

    public InputUserInfo(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public Locale inputLanguageInfo(){
        view.printMessage(TextConstant.INPUT_LANGUAGE);
        int i = 0;
        while (i < 1 || i > 2) {
            i = Integer.parseInt(inputValueWithScanner(TextConstant.INPUT_LANGUAGE, Regex.REGEX_NUMBER));
        }
        if (i == 1){
           return new Locale("en");
        }else
            return new Locale("ua", "UA");
    }
    public void choseOperation(){
        int i = 0;
        while (i < 1 || i >6) {
            i = Integer.parseInt(inputValueWithScanner(TextConstant.INPUT_STRING_DATA, Regex.REGEX_NUMBER));
        }
        switch (i) {
            case (1):
                List<TariffEnum> list = model.getTariffs();
                view.printMessage(TextConstant.INPUT_LIST_OF_TARIFFS);
                for (TariffEnum tariffEnum : list){
                    view.print(tariffEnum.toString());
                }
                break;
            case (2):
                List<TariffEnum> list2 = sortTariffList(model.getTariffs());
                view.printMessage(TextConstant.INPUT_LIST_OF_SORTED_TARIFFS);
                for (TariffEnum tariffEnum : list2){
                    view.print(tariffEnum.toString());
                }
                break;
            case (3):
                    view.printMessage(TextConstant.INPUT_AMOUNT_OF_USERS);
                    view.print(String.valueOf(TariffEnum.allClientCount()));
                break;
            case (4):

                List<TariffEnum> list3 = findTariffByParam();
                view.printMessage(TextConstant.INPUT_LIST_OF_TARIFFS);
                for (TariffEnum tariffEnum : list3){
                    view.print(tariffEnum.toString());
                }
                break;
            case (5):
                break;
        }

    }
    public String inputValueWithScanner(String message, String regex){
        String res;
        view.printMessage(message);
        while( !(sc.hasNext() && (res = sc.next()).matches(regex))) {
            view.printMessage(TextConstant.INPUT_ERROR);
        }
        return res;
    }
    public List<TariffEnum> sortTariffList(List<TariffEnum> tariffEnums){
        List<TariffEnum> list = new ArrayList<>(tariffEnums);
        list.sort(comparing(TariffEnum::getTariffCost));
        return list;
    }
    public List<TariffEnum> findTariffByParam(){
        int i = 0;
        int max = 0;
        int min = 0;
        List<TariffEnum> tariffEnumList = new ArrayList<>();
        while (i < 1 || i > 4) {
            i = Integer.parseInt(inputValueWithScanner(TextConstant.INPUT_CHOSE_PARAMS, Regex.REGEX_NUMBER));
        }

        while (min < 1 || min > 20000) {
            min = Integer.parseInt(inputValueWithScanner(TextConstant.INPUT_MIN, Regex.REGEX_NUMBER));
            if (min < 1 || min > 20000)
            view.printMessage(TextConstant.INPUT_ERROR_OF_BOUND);
        }

        while (max < 1 || max > 20000) {
            max = Integer.parseInt(inputValueWithScanner(TextConstant.INPUT_MAX, Regex.REGEX_NUMBER));
            if(max < min || max > 20000)
            view.printMessage(TextConstant.INPUT_ERROR_OF_BOUND);
        }
        System.out.println(max);
       switch (i){
           case (1):
               tariffEnumList = tariffSearcher.findTariffsByTariffCost(min, max);
               break;
           case (2):
               tariffEnumList = tariffSearcher.findTariffsByMinutesCount(min, max);
               break;
           case(3):
               tariffEnumList = tariffSearcher.findTariffsByMassageCount(min, max);
               break;
           case (4):
               tariffEnumList = tariffSearcher.findTariffsByInternetCount(min, max);
               break;
       }
        return tariffEnumList;
    }

}
