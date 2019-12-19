package it.osl.jscomponent.web.screens.prodotto;

import com.haulmont.cuba.gui.screen.*;
import it.osl.jscomponent.entity.Prodotto;

@UiController("jscomponent_Prodotto.browse")
@UiDescriptor("prodotto-browse.xml")
@LookupComponent("prodottoesTable")
@LoadDataBeforeShow
public class ProdottoBrowse extends StandardLookup<Prodotto> {
}