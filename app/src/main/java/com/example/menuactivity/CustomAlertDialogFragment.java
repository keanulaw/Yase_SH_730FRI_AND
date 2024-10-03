package com.example.menuactivity;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class CustomAlertDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle("Custom Dialog")
                .setMessage("This is a custom dialog message.")
                .setPositiveButton("Go to Home", (dialog, id) -> {
                    NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                    navController.navigate(R.id.navigation_preferences);
                })
                .setNegativeButton("Go to Settings", (dialog, id) -> {
                    NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                    navController.navigate(R.id.navigation_preferences);
                });
        return builder.create();
    }
}


