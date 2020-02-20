package model;


/**
 * Created on 16.02.2020
 * @author Vladyslav Osypchuk
 * @version 2.1
 */
public enum TariffEnum {
    LIFEHACK(new UserTariff("life hack",23456, 150, 1500, 0, 20)),
    BOMB(new UserTariff("bomb",3244, 150, 1000, 100, 20)),
    SMARTFAMILY(new UserTariff("smart family", 3456, 179, 300, 500, 12)),
    PLATINUM(new CorporationTariff(234, 5000, 250, 2500, 500, 30)),
    PREMIUM(new CorporationTariff(555,6578, 400, 3000, 1500, 15)),
    HEAT(new UserTariff("heat",345678, 50, 500, 0, 15)),
    FORBUSSINES(new CorporationTariff(666, 6578, 1000, 3000, 3000, 40));


    private final Tariff tariff;

//    private TariffEnum(long clientCount, int tariffCost, int minutesCount, int messagesCount, int internetCount) {
//        this.clientCount = clientCount;
//        this.tariffCost = tariffCost;
//        this.minutesCount = minutesCount;
//        this.messagesCount = messagesCount;
//        this.internetCount = internetCount;
//    }

    TariffEnum(Tariff tariff) {
        this.tariff = tariff;
    }

    /**
     *
     * @return amount of tariff users
     */
    public long getClientCount() {
        return tariff.getClientCount();
    }
    /**
     *
     * @return cost of tariff
     */
    public int getTariffCost() {
        return tariff.getTariffCost();
    }

    /**
     *
     * @return amount of minutes available with this tariff
     */
    public int getMinutesCount() {
        return tariff.getMinutesCount();
    }
    /**
     *
     * @return amount of messages available with this tariff
     */
    public int getMessagesCount() {
        return tariff.getMessagesCount();
    }
    /**
     *
     * @return amount of GB available with this tariff
     */
    public int getInternetCount() {
        return tariff.getInternetCount();
    }

    /**
     *
     * @return count of users from all tariffs
     */
    public static long allClientCount(){
        long count = 0;
        for (TariffEnum tariffEnum : TariffEnum.values())
        count+=tariffEnum.getClientCount();
        return count;
    }

    /**
     *
     * @return string value of current tariff
     */
    @Override
    public String toString() {
        return tariff.toString();
    }
}
