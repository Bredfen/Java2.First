import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Background {
    private final Color DAY_COLOR = Color.WHITE;
    private final Color NIGHT_COLOR = Color.BLACK;
    private SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH");
    private String formated_date;
    private int value_of_hours;
    public void setCurrentColor(GameCanvas g) {
        Date d = new Date();
        formated_date = formatForDateNow.format(d);
        value_of_hours = Integer.parseInt(formated_date);
        g.setBackground(((value_of_hours < 8) || (value_of_hours > 21)) ? NIGHT_COLOR : DAY_COLOR);

    }
}
