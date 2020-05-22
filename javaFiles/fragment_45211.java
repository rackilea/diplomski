Account sender = accountRepository.findById(result.getSenderAccountId()).get();
sender.setBalance(emitterFinalBalance);
accountRepository.save(sender);

Account receiver = accountRepository.findById(result.getReceiverAccountId()).get();
receiver.setBalance(receptorFinalBalance);
accountRepository.save(receiver);