package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.day01.R;

import java.util.List;

import bean.NotepadBean;

public class NotepadAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<NotepadBean> list;

    public NotepadAdapter(Context context, List<NotepadBean> list) {
        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_layout, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        NotepadBean noteInfo = (NotepadBean) getItem(position);
        viewHolder.tvNoteoadContent.setText(noteInfo.getNoteContent());
        viewHolder.tvNotepadTime.setText(noteInfo.getNoteTime());
        return convertView;
    }

    class ViewHolder {
        TextView tvNoteoadContent;
        TextView tvNotepadTime;

        public ViewHolder(View view) {
            tvNoteoadContent = view.findViewById(R.id.item_content);
            tvNotepadTime = view.findViewById(R.id.item_time);
        }
    }

}

