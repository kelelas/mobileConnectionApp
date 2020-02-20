package model;

import java.util.ArrayList;
import java.util.List;


/**
 * Created on 16.02.2020
 * @author Vladyslav Osypchuk
 * @version 2.1
 */
public class Model {
    /**
     * array with tariffs
     */
    private static List<TariffEnum> tariffs = new ArrayList<TariffEnum>();
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
}
