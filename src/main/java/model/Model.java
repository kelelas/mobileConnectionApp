package model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;


/**
 * Created on 16.02.2020
 * @author Vladyslav Osypchuk
 * @version 3.2
 */
public class Model {
    /**
     * array with tariffs
     */
    private  List<TariffEnum> tariffs = new ArrayList<TariffEnum>();
    private  List<TariffEnum> SortTariffs = new ArrayList<TariffEnum>();

    /**
     *
     * @return array of available tariffs
     */
    public List<TariffEnum> getTariffs() {
        return tariffs;
    }

    /**
     * set array
     * @param tariffs (array of tariffs)
     */
    public void setTariffs(List<TariffEnum> tariffs) {
        this.tariffs = tariffs;
    }

    /**
     * method witch add tariff to array
     * @param tariffEnum (tariff from TariffEnum)
     */
    public void addTariff(TariffEnum tariffEnum){
        tariffs.add(tariffEnum);
    }

    /**
     * method return tariff from array by index
     * @param index (position in array)
     * @return current tariff from array by index
     */
    public TariffEnum getTariffFromListByIndex(int index){
        return  tariffs.get(index);
    }

    public List<TariffEnum> getSortTariffs() {
        return SortTariffs;
    }

    public void setSortTariffs(List<TariffEnum> sortTariffs) {
        SortTariffs = sortTariffs;
    }

    public void fillArray(){
       addTariff(TariffEnum.BOMB);
       addTariff(TariffEnum.LIFEHACK);
       addTariff(TariffEnum.PLATINUM);
       addTariff(TariffEnum.PREMIUM);
       addTariff(TariffEnum.SMARTFAMILY);
       addTariff(TariffEnum.HEAT);
       addTariff(TariffEnum.FORBUSSINES);
    }
    public List<TariffEnum> sortTariffList(List<TariffEnum> tariffEnums){
        List<TariffEnum> list = new ArrayList<>(tariffEnums);
        list.sort(comparing(TariffEnum::getTariffCost));
        return list;
    }
    public List<TariffEnum> findTariffsByTariffCost(int min, int max){
        List<TariffEnum> list = new ArrayList<>();
        for (TariffEnum tariffEnum : tariffs){
            if (tariffEnum.getTariffCost() > min && tariffEnum.getTariffCost() < max){
                list.add(tariffEnum);
            }
        }
        return list;
    }
    public List<TariffEnum> findTariffsByMassageCount(int min, int max){
        List<TariffEnum> list = new ArrayList<>();
        for (TariffEnum tariffEnum : tariffs){
            if (tariffEnum.getMessagesCount() > min && tariffEnum.getMessagesCount() < max){
                list.add(tariffEnum);
            }
        }
        return list;
    }
    public List<TariffEnum> findTariffsByMinutesCount(int min, int max){
        List<TariffEnum> list = new ArrayList<>();
        for (TariffEnum tariffEnum : tariffs){
            if (tariffEnum.getMinutesCount() > min && tariffEnum.getMinutesCount() < max){
                list.add(tariffEnum);
            }
        }
        return list;
    }
    public List<TariffEnum> findTariffsByInternetCount(int min, int max){
        List<TariffEnum> list = new ArrayList<>();
        for (TariffEnum tariffEnum : tariffs){
            if (tariffEnum.getInternetCount() > min && tariffEnum.getInternetCount() <= max){
                list.add(tariffEnum);
            }
        }
        return list;
    }
}
