import controller.Controller;
import controller.InputUserInfo;
import model.Model;
import view.View;

/**
 * Created on 16.02.2020
 * @author Vladyslav Osypchuk
 * @version 1.1
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        InputUserInfo inputUserInfo = new InputUserInfo( view, model);
        Controller controller = new Controller(model, view, inputUserInfo);
        controller.processUser();
    }
}
