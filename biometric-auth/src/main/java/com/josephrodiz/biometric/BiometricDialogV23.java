package com.josephrodiz.biometric;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class BiometricDialogV23 extends DialogFragment {

    private BiometricCallback biometricCallback;

    private ViewSupplierV23 viewSupplier;

    public View customView;

    public BiometricDialogV23(BiometricCallback biometricCallback, ViewSupplierV23 viewSupplier) {
        this.biometricCallback = biometricCallback;
        this.viewSupplier = viewSupplier;
    }

    public void dismiss() {
        super.dismiss();
        biometricCallback.onAuthenticationCancelled();
        customView = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        customView = inflater.inflate(viewSupplier.getCustomId(), null);
        builder.setView(customView);
        viewSupplier.onViewInflated(this);
        return builder.create();
    }
}
