package com.josephrodiz.biometric;

import android.content.Context;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import androidx.annotation.NonNull;

public class BiometricDialogV23 extends BottomSheetDialog {

    private BiometricCallback biometricCallback;

    private ViewSupplierV23 viewSupplier;


    public BiometricDialogV23(@NonNull Context context) {
        super(context, R.style.BottomSheetDialogTheme);
        setDialogView();
    }

    public BiometricDialogV23(@NonNull Context context, BiometricCallback biometricCallback, ViewSupplierV23 viewSupplier) {
        super(context, R.style.BottomSheetDialogTheme);
        this.biometricCallback = biometricCallback;
        this.viewSupplier = viewSupplier;
        setDialogView();
    }

    public BiometricDialogV23(@NonNull Context context, int theme) {
        super(context, theme);
    }

    protected BiometricDialogV23(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    private void setDialogView() {
        View customView = getLayoutInflater().inflate(viewSupplier.getCustomId(), null);
        setContentView(customView);
        viewSupplier.onViewInflated(this);
    }

    public void dismiss() {
        super.dismiss();
        biometricCallback.onAuthenticationCancelled();
    }
}
