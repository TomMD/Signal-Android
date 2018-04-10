package org.thoughtcrime.securesms.util.concurrent;

import java.util.concurrent.ExecutionException;
import org.thoughtcrime.securesms.util.concurrent.ListenableFuture.Listener;

public abstract class AssertedSuccessListener<T> implements Listener<T> {
  @Override
  public void onFailure(ExecutionException e) {
    throw new AssertionError(e);
  }
}
