package it.osl.jscomponent.web.screens.prodotto;

import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.app.core.inputdialog.DialogActions;
import com.haulmont.cuba.gui.app.core.inputdialog.InputDialog;
import com.haulmont.cuba.gui.app.core.inputdialog.InputParameter;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.gui.components.JavaScriptComponent;
import it.osl.jscomponent.entity.Prodotto;

import javax.inject.Inject;

@UiController("jscomponent_Prodotto.edit")
@UiDescriptor("prodotto-edit.xml")
@EditedEntityContainer("prodottoDc")
@LoadDataBeforeShow
public class ProdottoEdit extends StandardEditor<Prodotto> {
    @Inject
    private JavaScriptComponent fabric;
    @Inject
    private Notifications notifications;
    @Inject
    private Dialogs dialogs;

    public class State{
        public double left;
        public double top;
    }

    @Subscribe
    public void onInit(InitEvent event) {
        fabric.addFunction("selectedCircle", javaScriptCallbackEvent -> {
            String xxx = javaScriptCallbackEvent.getArguments().getString(0);
            notifications.create()
                    .withCaption(xxx.toString())
                    .withPosition(Notifications.Position.MIDDLE_CENTER)
                    .show();
        });

        fabric.addFunction("createdObject", javaScriptCallbackEvent -> {
            notifications.create()
                    .withCaption("creato cerchio")
                    .withPosition(Notifications.Position.MIDDLE_CENTER)
                    .show();
        });
    }

    public void onAddCircleBtnClick() {
        dialogs.createInputDialog(this)
                .withCaption("Enter some values")
                .withParameters(
                        InputParameter.doubleParameter("left")
                                .withCaption("Left").withRequired(true).withDefaultValue(200.0),
                        InputParameter.doubleParameter("top")
                                .withCaption("Top").withDefaultValue(100.0)
                )
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.getCloseAction().equals(InputDialog.INPUT_DIALOG_OK_ACTION)) {
                        State state = new State();
                        state.left = closeEvent.getValue("left");
                        state.top = closeEvent.getValue("top");
                        fabric.setState(state);
                    }
                })
                .show();


    }
}