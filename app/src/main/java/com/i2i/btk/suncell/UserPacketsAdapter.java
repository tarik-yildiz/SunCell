package com.i2i.btk.suncell;


import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserPacketsAdapter extends RecyclerView.Adapter<UserPacketsAdapter.UserPacketModelView> {

    Context context;
    List<UserPacketInfoModel> list;


    public UserPacketsAdapter(Context context, List<UserPacketInfoModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UserPacketModelView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(context).inflate(R.layout.model_user_packets, parent, false);
        return new UserPacketModelView(layout);
    }


    @Override
    public void onBindViewHolder(@NonNull UserPacketModelView holder, int position) {
        float left = list.get(position).getTotal() - list.get(position).getUsed();
        float total = list.get(position).getTotal();
        float used=list.get(position).getUsed();
        int leftPercent = (int) (100 * (left / total));
        holder.nameOfPackage.setText(list.get(position).getNameOfPacket());
        holder.totalPackage.setText("" + total);
        holder.usedPackage.setText("" + used);
        holder.leftPackage.setText("" + left);
        holder.progressBarText.setText("%" + leftPercent);

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <= leftPercent; i++) {
                    // İşleminiz burada yapılır
                    final int progress = i; // İlerleme yüzdesi hesaplanır
                    holder.progressBarBalance.setProgress(progress); // ProgressBar güncellenir

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i <= total; i++) {
                            final int progress = i;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    holder.totalPackage.setText(""+progress);
                                }
                            });
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i <= used; i++) {
                            final int progress = i;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    holder.usedPackage.setText(""+progress);
                                }
                            });
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i <= left; i++) {
                            final int progress = i;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    holder.leftPackage.setText(""+progress);
                                }
                            });
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

            }
        });
        myThread.start();


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class UserPacketModelView extends RecyclerView.ViewHolder {
        TextView nameOfPackage, totalPackage, usedPackage, leftPackage, progressBarText;
        ProgressBar progressBarBalance;

        public UserPacketModelView(@NonNull View itemView) {
            super(itemView);
            nameOfPackage = itemView.findViewById(R.id.textViewUserPacketName);
            totalPackage = itemView.findViewById(R.id.textViewUserPackageTotal);
            usedPackage = itemView.findViewById(R.id.textViewUserPackageUsed);
            leftPackage = itemView.findViewById(R.id.textViewUserBalance);
            progressBarBalance = itemView.findViewById(R.id.progressBarBalance);
            progressBarText = itemView.findViewById(R.id.progressBarText);
        }
    }
}
