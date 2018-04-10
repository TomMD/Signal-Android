package org.thoughtcrime.securesms.mms;

import java.util.LinkedList;
import org.thoughtcrime.securesms.attachments.Attachment;
import org.thoughtcrime.securesms.database.ThreadDatabase;
import org.thoughtcrime.securesms.recipients.Recipient;

public class OutgoingExpirationUpdateMessage extends OutgoingSecureMediaMessage {

  public OutgoingExpirationUpdateMessage(Recipient recipient, long sentTimeMillis, long expiresIn) {
    super(
        recipient,
        "",
        new LinkedList<Attachment>(),
        sentTimeMillis,
        ThreadDatabase.DistributionTypes.CONVERSATION,
        expiresIn);
  }

  @Override
  public boolean isExpirationUpdate() {
    return true;
  }
}
