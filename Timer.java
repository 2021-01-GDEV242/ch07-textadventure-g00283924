
/**
 * Write a description of class Timer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Timer
{
private int timer;
private int update;
private int low;

public Timer(int defaultTime, int defaultUpdate, int defaultLow) {
timer = defaultTime;
update = defaultUpdate;
low = defaultLow;
}

/**
* prints out the timer.
*/
public String toString() {
return Integer.toString(timer);
}

/**
* updates the timer
*/
public void updateTimer() {
timer += update;
}

/**
* alter timer data
*/
public void setTime(int time) {
timer = time;
}

public void setUpdate(int update) {
this.update = update;
}

public void setLow(int low) {
this.low = low;
}

/**
* This will check if the timer is low
*/
public boolean isLow() {
if (timer <= low) {
return true;
}
return false;
}

    /**
   * This will check if the timer is 0
  */
    public boolean hasExpired() {
    if (timer <= 0) {
    return true;
    }
    return false;
}
}