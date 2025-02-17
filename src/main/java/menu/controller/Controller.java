package menu.controller;

import menu.model.CoachInfo;
import menu.model.FoodList;
import menu.model.GenerateCategory;
import menu.model.GenerateMenu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class Controller {

    public InputView inputView;
    public OutputView outputView;
    public CoachInfo coachInfo;
    public GenerateCategory generateCategory;
    public GenerateMenu generateMenu;

    private Controller(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.coachInfo = new CoachInfo();
        this.generateCategory = new GenerateCategory();

        process();
    }

    public static Controller start() {
        return new Controller();
    }

    private void process(){
        outputView.startMessage();
        coachNameInput();
        coachRestrictionInput(coachInfo.getCoachNames());
        outcome();
    }

    private void coachNameInput(){
        try {
            coachInfo.validateCoachNumber(inputView.coachNameInputMessage());
        }catch (IllegalArgumentException e){
            outputView.errorMessage(e.getMessage());
            coachNameInput();
        }
    }

    private void coachRestrictionInput(List<String> coachNames) {
        for(String coach:coachNames) {
            try {
                coachRestrictionInputIndividual(coach);
            } catch (IllegalArgumentException e) {
                outputView.errorMessage(e.getMessage());
                coachRestrictionInputIndividual(coach);
            }
        }
    }

    private void coachRestrictionInputIndividual(String coach){
        coachInfo.validateCoachRestrictionNumber(inputView.foodThatCantEat(coach));
    }

    private void outcome(){
        outputView.weekdayMessage(FoodList.weekday);
        outputView.categoryOutcomeMessage(generateCategory.getCategoriesResult());
        generateMenus();
        outputView.menuOutcomeMessage(generateMenu.getMenusResult());
        outputView.endMessage();
    }

    private void generateMenus(){
        List<String> categories = generateCategory.getCategoriesResult();
        List<String> coachNames = coachInfo.getCoachNames();
        List<List<String>> coachRestrictions = coachInfo.getCoachRestrictions();

        this.generateMenu = new GenerateMenu(coachNames, categories, coachRestrictions);
    }

}
