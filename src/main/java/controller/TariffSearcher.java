package controller;

import model.Model;
import model.TariffEnum;

import java.util.ArrayList;
import java.util.List;

public class TariffSearcher {

    static Model model = new Model();


    public static List<TariffEnum> findTariffsByTariffCost(int min, int max){
        List<TariffEnum> list = new ArrayList<>();
        for (TariffEnum tariffEnum : model.getTariffs()){
            if (tariffEnum.getTariffCost() > min && tariffEnum.getTariffCost() < max){
                list.add(tariffEnum);
            }
        }
        return list;
    }
    public static List<TariffEnum> findTariffsByMassageCount(int min, int max){
        List<TariffEnum> list = new ArrayList<>();
        for (TariffEnum tariffEnum : model.getTariffs()){
            if (tariffEnum.getMessagesCount() > min && tariffEnum.getMessagesCount() < max){
                list.add(tariffEnum);
            }
        }
        return list;
    }
    public static List<TariffEnum> findTariffsByMinutesCount(int min, int max){
        List<TariffEnum> list = new ArrayList<>();
        for (TariffEnum tariffEnum : model.getTariffs()){
            if (tariffEnum.getMinutesCount() > min && tariffEnum.getMinutesCount() < max){
                list.add(tariffEnum);
            }
        }
        return list;
    }
    public static List<TariffEnum> findTariffsByInternetCount(int min, int max){
        List<TariffEnum> list = new ArrayList<>();
        for (TariffEnum tariffEnum : model.getTariffs()){
            if (tariffEnum.getInternetCount() > min && tariffEnum.getInternetCount() <= max){
                list.add(tariffEnum);
            }
        }
        return list;
    }
}
