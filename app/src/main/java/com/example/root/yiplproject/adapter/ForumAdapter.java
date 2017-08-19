package com.example.root.yiplproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.root.yiplproject.ComplainActivity;
import com.example.root.yiplproject.ComplainDetail;
import com.example.root.yiplproject.ForumActivity;
import com.example.root.yiplproject.R;
import com.example.root.yiplproject.model.Complain;

import java.util.List;


/**
 * Created by user on 7/24/2017.
 */

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ViewHolder>{

    private List<Complain> complain;
    Context context;
    private static final int FOOTER_VIEW = 1;

    public class FooterViewHolder extends ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);

        }
    }

    public class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(final View itemView) {
            super(itemView);


        }
    }
    public ForumAdapter(List<Complain> complain, Context context) {
        this.complain = complain;
        this.context=context;
    }

    @Override
    public ForumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_forum, parent, false);
//        return new ViewHolder(view);
        View v;
        if (viewType == FOOTER_VIEW) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_recyler, parent, false);

            FooterViewHolder vh = new FooterViewHolder(v);

            return vh;
        }

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_forum, parent, false);

        NormalViewHolder vh = new NormalViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ForumAdapter.ViewHolder holder, final int position) {



        try {
            if (holder instanceof NormalViewHolder) {
                NormalViewHolder vh = (NormalViewHolder) holder;
                vh.linear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Do whatever you want on clicking the normal items

                        Intent intent=new Intent(context, ComplainDetail.class);
                        intent.putExtra("hello",complain.get(position));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                });

                vh.bindView(position);
            } else if (holder instanceof FooterViewHolder) {
                FooterViewHolder vh = (FooterViewHolder) holder;
                vh.btn_post.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context,ComplainActivity.class);
                        context.startActivity(intent);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public int getItemViewType(int position) {
        if (position == complain.size()) {
            // This is where we'll add footer.
            return FOOTER_VIEW;
        }

        return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        if (complain == null) {
            return 0;
        }

        if (complain.size() == 0) {
            //Return 1 here to show nothing
            return 1;
        }

        // Add extra view to show the footer view
        return complain.size() + 1;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_date, tv_head, tv_body;
        LinearLayout linear;
        Button btn_post;

        public ViewHolder(View view) {
            super(view);
            linear=(LinearLayout)view.findViewById(R.id.linear);
            tv_date = (TextView) view.findViewById(R.id.tv_date);
            tv_head = (TextView) view.findViewById(R.id.tv_head);
            tv_body = (TextView) view.findViewById(R.id.tv_body);
            btn_post=(Button)view.findViewById(R.id.btn_postComp);

        }

        public void bindView(int position) {
            // bindView() method to implement actions
            tv_date.setText(complain.get(position).getDatee());
        tv_head.setText(complain.get(position).getHead());
        tv_body.setText(complain.get(position).getBody());

        }
    }
}