package android.cuong.surveymvp.ui.base;

/**
 * Created by QUOC CUONG on 19/11/2017.
 */

/**
 * All dialogs want to act as View in MVP must implements this interface.
 */

public interface DialogMvpView extends MvpView {

    void dismisDialog(String tag);
}
