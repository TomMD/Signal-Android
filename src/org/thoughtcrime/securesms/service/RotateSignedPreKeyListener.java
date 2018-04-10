package org.thoughtcrime.securesms.service;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.TimeUnit;
import org.thoughtcrime.securesms.ApplicationContext;
import org.thoughtcrime.securesms.jobs.RotateSignedPreKeyJob;
import org.thoughtcrime.securesms.util.TextSecurePreferences;

public class RotateSignedPreKeyListener extends PersistentAlarmManagerListener {

  private static final long INTERVAL = TimeUnit.DAYS.toMillis(2);

  @Override
  protected long getNextScheduledExecutionTime(Context context) {
    return TextSecurePreferences.getSignedPreKeyRotationTime(context);
  }

  @Override
  protected long onAlarm(Context context, long scheduledTime) {
    if (scheduledTime != 0 && TextSecurePreferences.isPushRegistered(context)) {
      ApplicationContext.getInstance(context)
          .getJobManager()
          .add(new RotateSignedPreKeyJob(context));
    }

    long nextTime = System.currentTimeMillis() + INTERVAL;
    TextSecurePreferences.setSignedPreKeyRotationTime(context, nextTime);

    return nextTime;
  }

  public static void schedule(Context context) {
    new RotateSignedPreKeyListener().onReceive(context, new Intent());
  }
}
