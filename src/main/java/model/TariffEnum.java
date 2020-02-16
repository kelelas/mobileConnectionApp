package model;


/**
 * Created on 16.02.2020
 * @author Vladyslav Osypchuk
 * @version 1.1
 */
public enum TariffEnum {
    LIFEHACK(23456, 150, 1500, 0, 20),
    BOMB(3244, 150, 1000, 100, 20),
    SMARTFAMILY(3456, 179, 300, 500, 12),
    PLATINUM(5000, 250, 2500, 500, 30),
    PREMIUM(6578, 400, 3000, 1500, 15),
    HEAT(345678, 50, 500, 0, 15);

    /**
     * field with number of current tariff users
     */
    private final long  clientCount;
    /**
     * field with cost of current tariff
     */
    private final int tariffCost;
    /**
     * field with amount of minutes available to the user
     */
    private final int minutesCount;
    /**
     * field with amount of messages available to the user
     */
    private final int messagesCount;
    /**
     * field with amount of GB available to the user
     */
    private final int internetCount;

    private TariffEnum(long clientCount, int tariffCost, int minutesCount, int messagesCount, int internetCount) {
        this.clientCount = clientCount;
        this.tariffCost = tariffCost;
        this.minutesCount = minutesCount;
        this.messagesCount = messagesCount;
        this.internetCount = internetCount;
    }

    /**
     *
     * @return amount of tariff users
     */
    public long getClientCount() {
        return clientCount;
    }
    /**
     *
     * @return cost of tariff
     */
    public int getTariffCost() {
        return tariffCost;
    }

    /**
     *
     * @return amount of minutes available with this tariff
     */
    public int getMinutesCount() {
        return minutesCount;
    }
    /**
     *
     * @return amount of messages available with this tariff
     */
    public int getMessagesCount() {
        return messagesCount;
    }
    /**
     *
     * @return amount of GB available with this tariff
     */
    public int getInternetCount() {
        return internetCount;
    }

    /**
     *
     * @return count of users from all tariffs
     */
    public static long allClientCount(){
        return LIFEHACK.getClientCount() + BOMB.getClientCount() + SMARTFAMILY.getClientCount() + PLATINUM.getClientCount() + PREMIUM.getClientCount() + HEAT.getClientCount();
    }

    /**
     *
     * @return string value of current tariff
     */
    @Override
    public String toString() {
        return TariffEnum.this.name() + " {" +
                "clientCount=" + clientCount +
                ", tariffCost=" + tariffCost +
                ", minutesCount=" + minutesCount +
                ", messagesCount=" + messagesCount +
                ", internetCount=" + internetCount +
                '}';
    }
}
