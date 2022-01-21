package com.example.layoutinspector;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mi.layoutinspector.widget.CustomDialog;

import org.jetbrains.annotations.NotNull;


/**
 * create by niuxiaowei
 * date : 21-8-26
 **/
public class MainFragment extends Fragment {

    private AddToContentViewFragment addToContentViewFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                addToContentViewFragment = new AddToContentViewFragment();
                fragmentTransaction.add(android.R.id.content, addToContentViewFragment).commit();
            }
        });

        view.findViewById(R.id.show_toast).setOnClickListener(v -> Toast.makeText(getContext(), "hello bottom", Toast.LENGTH_LONG).show());

        view.findViewById(R.id.show_dialog).setOnClickListener(v -> {
            new CustomDialog(getContext(), new CustomDialog.IOkClickListener() {
                @Override
                public void onOkClick(@NotNull String editMsg) {
                    Toast.makeText(getContext(), "ok click", Toast.LENGTH_LONG).show();
                }
            }, "我是一个对话框", "没有点击事件").show();
        });

        view.findViewById(R.id.show_pupupwindow).setOnClickListener(v -> {
            new CustomDialog(getContext(), new CustomDialog.IOkClickListener() {
                @Override
                public void onOkClick(@NotNull String editMsg) {
                    Toast.makeText(getContext(), "ok click", Toast.LENGTH_LONG).show();
                }
            }, "我是一个对话框", "没有点击事件").show();
        });
    }

    public void onBackPressed() {
        if (addToContentViewFragment != null) {
            FragmentManager manager = getActivity().getFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.remove(addToContentViewFragment).commit();
            addToContentViewFragment = null;
        } else {
            getActivity().finish();
        }
    }


}
