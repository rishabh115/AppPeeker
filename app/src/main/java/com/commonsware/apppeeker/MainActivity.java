/*
 Copyright (c) 2017 CommonsWare, LLC
 Licensed under the Apache License, Version 2.0 (the "License"); you may not
 use this file except in compliance with the License. You may obtain a copy
 of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
 by applicable law or agreed to in writing, software distributed under the
 License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 OF ANY KIND, either express or implied. See the License for the specific
 language governing permissions and limitations under the License.
 */

package com.commonsware.apppeeker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class MainActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.main);

    TextView status=findViewById(R.id.status);

    if (PeekerApp.INSTANTIATE_ACTIVITY_CALLED) {
      status.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
      status.setText(getString(R.string.status, getString(R.string.called)));
    }
    else {
      status.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
      status.setText(getString(R.string.status, getString(R.string.not_called)));
    }

    RecyclerView rv=findViewById(R.id.methods);

    rv.setLayoutManager(new LinearLayoutManager(this));
    rv.addItemDecoration(new DividerItemDecoration(this,
      LinearLayoutManager.VERTICAL));
    rv.setAdapter(new AppMethodsAdapter());
  }

  class AppMethodsAdapter extends RecyclerView.Adapter<RowHolder> {
    final Method[] methods;

    AppMethodsAdapter() {
      methods=Application.class.getDeclaredMethods();

      Arrays.sort(methods, new Comparator<Method>() {
        @Override
        public int compare(Method left, Method right) {
          return left.getName().compareTo(right.getName());
        }
      });
    }

    @Override
    public RowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View row=getLayoutInflater()
        .inflate(android.R.layout.simple_list_item_1, parent, false);

      return(new RowHolder(row));
    }

    @Override
    public void onBindViewHolder(RowHolder holder, int position) {
      holder.bind(methods[position]);
    }

    @Override
    public int getItemCount() {
      return methods.length;
    }
  }

  static class RowHolder extends RecyclerView.ViewHolder {
    final TextView title;

    RowHolder(View itemView) {
      super(itemView);

      title=itemView.findViewById(android.R.id.text1);
    }

    void bind(Method method) {
      title.setText(method.getName()+"()");
    }
  }
}
