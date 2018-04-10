package org.thoughtcrime.securesms.mms;

import java.util.List;
import org.thoughtcrime.securesms.attachments.Attachment;
import org.thoughtcrime.securesms.recipients.Recipient;

public class OutgoingSecureMediaMessage extends OutgoingMediaMessage {

  public OutgoingSecureMediaMessage(
      Recipient recipient,
      String body,
      List<Attachment> attachments,
      long sentTimeMillis,
      int distributionType,
      long expiresIn) {
    super(recipient, body, attachments, sentTimeMillis, -1, expiresIn, distributionType);
  }

  public OutgoingSecureMediaMessage(OutgoingMediaMessage base) {
    super(base);
  }

  @Override
  public boolean isSecure() {
    return true;
  }
}
