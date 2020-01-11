package com.bawie.week03.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.week03.R;
import com.bawie.week03.model.bean.CartBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther:杜其林
 *@Date: 2020/1/11
 *@Time:11:33
 *@Description:${DESCRIPTION}
 * */ public class CartAdapter extends BaseExpandableListAdapter {

    private List<CartBean.ResultBean> result;

    public CartAdapter(List<CartBean.ResultBean> result) {

        this.result = result;
    }

    @Override
    public int getGroupCount() {
        return result.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return result.get(groupPosition).getShoppingCartList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, null);
            myViewHolder = new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        CartBean.ResultBean resultBean = result.get(groupPosition);
        myViewHolder.tvView.setText(resultBean.getCategoryName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart2_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = result.get(groupPosition).getShoppingCartList().get(childPosition);
        viewHolder.tvName.setText(shoppingCartListBean.getCommodityName());
        viewHolder.tvPrice.setText(shoppingCartListBean.getPrice() + "");
        Glide.with(viewHolder.image).load(shoppingCartListBean.getPic())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(viewHolder.image);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class MyViewHolder {
        @BindView(R.id.cb_box)
        CheckBox cbBox;
        @BindView(R.id.tv_view)
        TextView tvView;

        MyViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder {
        @BindView(R.id.cb_box)
        CheckBox cbBox;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_price)
        TextView tvPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
