package android.supremeaa.todo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.supremeaa.todo.Controller.TaskSerializer;
import android.supremeaa.todo.Model.Task;
import android.supremeaa.todo.Model.TaskAdapter;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.List;

/**
 * <h1>TodoApp</h1>
 * This to do App Allows users to create tasks that they must complete,
 * and assist them in completing them in the quickest most efficient way
 * possible
 * @author Philipp Faraee
 * @version 1.0
 * @since Monday, February 23, 2015 4:37:47 PM
 */
public class TodoActivity extends Activity  {
    public static Context context;
    public static ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        TodoActivity.context = getApplicationContext();
        JSONArray jsonArray = TaskSerializer.parseJSONFromAsset(TodoActivity.context);
        List<Task> taskList = TaskSerializer.returnList(jsonArray);

        listView = (ListView)findViewById(R.id.listView);
        TaskAdapter adapter = new TaskAdapter(this, R.layout.list_item, taskList);

        listView.setAdapter(adapter);
    }

}
