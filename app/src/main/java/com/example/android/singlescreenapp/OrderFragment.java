package com.example.android.singlescreenapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class OrderFragment extends Fragment {

    Cake cccObject;
    Cake scObject;
    Cake hcObject;
    Cake bcObject;
    TextView cccAmountTextView;
    TextView hcAmountTextView;
    TextView scAmountTextView;
    TextView bcAmountTextView;
    TextView totalPriceTextView;
    private int cccAmount = 0;
    private int hcAmount = 0;
    private int scAmount = 0;
    private int bcAmount = 0;
    private float totalPrice = 0;

    public OrderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            cccAmount = savedInstanceState.getInt("cccAmount");
            scAmount = savedInstanceState.getInt("scAmount");
            hcAmount = savedInstanceState.getInt("hcAmount");
            bcAmount = savedInstanceState.getInt("bcAmount");
            totalPrice = savedInstanceState.getFloat("totalPrice");

            refreshUI();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("cccAmount", cccAmount);
        outState.putInt("scAmount", scAmount);
        outState.putInt("hcAmount", hcAmount);
        outState.putInt("bcAmount", bcAmount);
        outState.putFloat("totalPrice", totalPrice);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_order, container, false);

        generateCakes();

        cccAmountTextView = (TextView) rootView.findViewById(R.id.amount_CCC);
        hcAmountTextView = (TextView) rootView.findViewById(R.id.amount_HC);
        scAmountTextView = (TextView) rootView.findViewById(R.id.amount_SC);
        bcAmountTextView = (TextView) rootView.findViewById(R.id.amount_BC);

        totalPriceTextView = (TextView) rootView.findViewById(R.id.total_price);

        ImageButton plusCccAmount = (ImageButton) rootView.findViewById(R.id.plus_CCC);
        plusCccAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cccAmount < 9) {
                    cccAmount += 1;
                    totalPrice += cccObject.GetPrice();
                    refreshCccAmount();
                    refreshTotalPrice();
                } else {
                    tooManyCakesToast();
                }
            }
        });

        ImageButton minusCccAmount = (ImageButton) rootView.findViewById(R.id.minus_CCC);
        minusCccAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cccAmount > 0) {
                    cccAmount -= 1;
                    totalPrice -= cccObject.GetPrice();
                    refreshCccAmount();
                    refreshTotalPrice();
                } else {
                    tooFewCakesToast();
                }
            }
        });

        ImageButton plusScAmount = (ImageButton) rootView.findViewById(R.id.plus_SC);
        plusScAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scAmount < 9) {
                    scAmount += 1;
                    totalPrice += scObject.GetPrice();
                    refreshScAmount();
                    refreshTotalPrice();
                } else {
                    tooManyCakesToast();
                }
            }
        });

        ImageButton minusScAmount = (ImageButton) rootView.findViewById(R.id.minus_SC);
        minusScAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scAmount > 0) {
                    scAmount -= 1;
                    totalPrice -= scObject.GetPrice();
                    refreshScAmount();
                    refreshTotalPrice();
                } else {
                    tooFewCakesToast();
                }
            }
        });

        ImageButton plusHcAmount = (ImageButton) rootView.findViewById(R.id.plus_HC);
        plusHcAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hcAmount < 9) {
                    hcAmount += 1;
                    totalPrice += hcObject.GetPrice();
                    refreshHcAmount();
                    refreshTotalPrice();
                } else {
                    tooManyCakesToast();
                }
            }
        });

        ImageButton minusHcAmount = (ImageButton) rootView.findViewById(R.id.minus_HC);
        minusHcAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hcAmount > 0) {
                    hcAmount -= 1;
                    totalPrice -= hcObject.GetPrice();
                    refreshHcAmount();
                    refreshTotalPrice();
                } else {
                    tooFewCakesToast();
                }
            }
        });

        ImageButton plusBcAmount = (ImageButton) rootView.findViewById(R.id.plus_BC);
        plusBcAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bcAmount < 9) {
                    bcAmount += 1;
                    totalPrice += bcObject.GetPrice();
                    refreshBcAmount();
                    refreshTotalPrice();
                } else {
                    tooManyCakesToast();
                }
            }
        });

        ImageButton minusBcAmount = (ImageButton) rootView.findViewById(R.id.minus_BC);
        minusBcAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bcAmount > 0) {
                    bcAmount -= 1;
                    totalPrice -= bcObject.GetPrice();
                    refreshBcAmount();
                    refreshTotalPrice();
                } else {
                    tooFewCakesToast();
                }
            }
        });

        Button placeOrderButton = (Button) rootView.findViewById(R.id.place_order);
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder();
            }
        });

        refreshUI();

        return rootView;
    }

    private void generateCakes() {
        cccObject = new Cake("Cottage cheese cake", R.drawable.cottage, 3.22);
        scObject = new Cake("Strawberry cake", R.drawable.strawb, 4.22);
        hcObject = new Cake("Honey cake", R.drawable.honey, 6.18);
        bcObject = new Cake("Bread cake", R.drawable.bread, 4.55);
    }

    private void refreshTotalPrice() {
        totalPriceTextView.setText(String.format("%.2f", totalPrice) + " $");
    }

    private void refreshCccAmount() {
        cccAmountTextView.setText(String.valueOf(cccAmount));
    }

    private void refreshScAmount() {
        scAmountTextView.setText(String.valueOf(scAmount));
    }

    private void refreshHcAmount() {
        hcAmountTextView.setText(String.valueOf(hcAmount));
    }

    private void refreshBcAmount() {
        bcAmountTextView.setText(String.valueOf(bcAmount));
    }

    private void tooManyCakesToast() {
        Toast.makeText(getActivity(), getResources().getString(R.string.too_many_cakes_message), Toast.LENGTH_SHORT).show();
    }

    private void tooFewCakesToast() {
        Toast.makeText(getActivity(), getResources().getString(R.string.too_few_cakes_message), Toast.LENGTH_SHORT).show();
    }

    private void placeOrder() {
        String orderMessage = getResources().getString(R.string.order_summary_message) + "\n"
                + getResources().getString(R.string.total_number_of_ccc) + " " + cccAmount + "\n"
                + getResources().getString(R.string.total_number_of_sc) + " " + scAmount + "\n"
                + getResources().getString(R.string.total_number_of_hc) + " " + hcAmount + "\n"
                + getResources().getString(R.string.total_number_of_bc) + " " + bcAmount + "\n"
                + getResources().getString(R.string.total_price_mail_message) + " " +
                String.format("%.2f", totalPrice);
        String[] mail = {getResources().getString(R.string.mail)};
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.mail_subject));
        intent.putExtra(Intent.EXTRA_EMAIL, mail);
        intent.putExtra(intent.EXTRA_TEXT, orderMessage);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null)
            startActivity(intent);
    }

    private void refreshUI() {
        refreshTotalPrice();
        refreshCccAmount();
        refreshScAmount();
        refreshHcAmount();
        refreshBcAmount();
    }
}


