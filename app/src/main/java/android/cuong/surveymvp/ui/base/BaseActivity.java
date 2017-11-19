package android.cuong.surveymvp.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.cuong.surveymvp.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Unbinder;

/**
 * Created by QUOC CUONG on 19/11/2017.
 */

/**
 * All activities must be extends this abstract class
 * TODO: implements BaseFragment.Callback
 */
public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    private ProgressDialog mProgressDialog;

    //TODO: reference ActivityComponent

    // butter knife unbinder
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: init ActivityComponent
    }

    //TODO: getActivityComponent funtion


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    //TODO: checkPermission by TargetAPI

    @Override
    public void showLoading() {
        hideLoading();
        //TODO: init progressDialog by CommonUtils
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }

    @Override
    public void onError(String message) {
        if (message != null) {
            showSnackBar(message);
        } else {
            showSnackBar(getString(R.string.some_error));
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        showMessage(getString(resId));
    }

    @Override
    public boolean isNetworkConnected() {
        //TODO: NetworkUtils
        return false;
    }

    //TODO: attach and detach Fragment


    @Override
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void openActivityOnTokenExpire() {
        //TODO: intent to LoginActivity
    }

    public void setUnbinder(Unbinder unbinder) {
        mUnbinder = unbinder;
    }

    @Override
    protected void onDestroy() {

        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    protected abstract void setUp();
}
