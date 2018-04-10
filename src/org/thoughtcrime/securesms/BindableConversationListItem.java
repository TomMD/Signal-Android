package org.thoughtcrime.securesms;

import android.support.annotation.NonNull;
import java.util.Locale;
import java.util.Set;
import org.thoughtcrime.securesms.database.model.ThreadRecord;
import org.thoughtcrime.securesms.mms.GlideRequests;

public interface BindableConversationListItem extends Unbindable {

  public void bind(
      @NonNull ThreadRecord thread,
      @NonNull GlideRequests glideRequests,
      @NonNull Locale locale,
      @NonNull Set<Long> selectedThreads,
      boolean batchMode);
}
