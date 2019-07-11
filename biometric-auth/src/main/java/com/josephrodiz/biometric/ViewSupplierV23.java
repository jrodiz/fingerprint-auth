package com.josephrodiz.biometric;

import androidx.annotation.LayoutRes;

public interface ViewSupplierV23 {
    @LayoutRes
    int getCustomId();

    void onViewInflated(final BiometricDialogV23 dialog);
}
