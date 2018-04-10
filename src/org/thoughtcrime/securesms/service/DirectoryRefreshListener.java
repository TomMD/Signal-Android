package org.thoughtcrime.securesms.service;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.TimeUnit;
import org.thoughtcrime.securesms.ApplicationContext;
import org.thoughtcrime.securesms.jobs.DirectoryRefreshJob;
import org.thoughtcrime.securesms.util.TextSecurePreferences;

public class DirectoryRefreshListener extends PersistentAlarmManagerListener {

  private static final long INTERVAL = TimeUnit.HOURS.toMillis(12);

  @Override
  protected long getNextScheduledExecutionTime(Context context) {
    return TextSecurePreferences.getDirectoryRefreshTime(context);
  }

  @Override
  protected long onAlarm(Context context, long scheduledTime) {
    if (scheduledTime != 0 && TextSecurePreferences.isPushRegistered(context)) {
      ApplicationContext.getInstance(context)
          .getJobManager()
          .add(new DirectoryRefreshJob(context, true));
    }

    long newTime = System.currentTimeMillis() + INTERVAL;
    TextSecurePreferences.setDirectoryRefreshTime(context, newTime);

    return newTime;
  }

  public static void schedule(Context context) {
    new DirectoryRefreshListener().onReceive(context, new Intent());
  }
}
