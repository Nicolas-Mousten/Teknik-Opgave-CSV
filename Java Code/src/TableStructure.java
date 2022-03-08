import java.util.ArrayList;

public class TableStructure {
    private ArrayList<String> title;
    private ArrayList<ImdbData> data;

    public TableStructure(ArrayList<String> title, ArrayList<ImdbData> data) {
        this.title = title;
        this.data = data;
    }

    public ArrayList<String> getTitle() {
        return title;
    }

    public ArrayList<ImdbData> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "TableStructure{" +
                "title=" + title +
                ", data=" + data +
                '}';
    }
}
