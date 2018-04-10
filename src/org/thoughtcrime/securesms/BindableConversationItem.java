package org.thoughtcrime.securesms;

import android.support.annotation.NonNull;
import java.util.Locale;
import java.util.Set;
import org.thoughtcrime.securesms.database.model.MessageRecord;
import org.thoughtcrime.securesms.mms.GlideRequests;
import org.thoughtcrime.securesms.recipients.Recipient;

public interface BindableConversationItem extends Unbindable {
  void bind(
      @NonNull MessageRecord messageRecord,
      @NonNull GlideRequests glideRequests,
      @NonNull Locale locale,
      @NonNull Set<MessageRecord> batchSelected,
      @NonNull Recipient recipients);

  MessageRecord getMessageRecord();
}
