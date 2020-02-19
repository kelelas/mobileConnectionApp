package controller;

import model.*;
import view.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import static java.util.Comparator.comparing;
/**
 * Created on 16.02.2020
 * @author Vladyslav Osypchuk
 * @version 1.1
 */
public class Controller {
    private Model model;
    private View view;
    private InputUserInfo inputUserInfo;
    public Controller(Model model, View view, InputUserInfo inputUserInfo) {
        this.model = model;
        this.view = view;
        this.inputUserInfo = inputUserInfo;
    }

    public void processUser() {
        fillArray();
        inputUserInfo.choseOperation();
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


}
