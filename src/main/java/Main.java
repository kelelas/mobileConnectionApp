import controller.Controller;
import model.Model;
import view.View;

/**
 * Created on 16.02.2020
 * @author Vladyslav Osypchuk
 * @version 2.1
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.processUser();
    }
}
