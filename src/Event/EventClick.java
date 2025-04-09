package Event;

import Model.DataSearch;
import java.awt.Component;

public interface EventClick {

    public void itemClick(DataSearch data);

    public void itemRemove(Component com, DataSearch data);
}
