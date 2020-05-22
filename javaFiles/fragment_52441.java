#!/usr/bin/python

from random import random, choice
from datetime import datetime
import tempfile

all_threads = set([])
running = []
hung = []
filenames = { }

target_thread_count = 16
hang_chance = 0.001

def log(id, msg):
    now = datetime.now().strftime("%m:%d %H:%M:%S")
    print "%s, ScriptExecThread(%i),Info,%s" % (now, id, msg)

def new_thread():
    if len(all_threads)>0:
        for t in range(0, 2+max(all_threads)):
            if t not in all_threads:
                all_threads.add(t)
                return t
    else:
        all_threads.add(0)
        return 0

for i in range(0, 100000):
    if len(running) > target_thread_count:
        new_thread_chance = 0.25
    else:
        new_thread_chance = 0.75
        pass

    if random() < new_thread_chance:
        t = new_thread()
        name = next(tempfile._get_candidate_names())+".txt"
        filenames[t] = name
        log(t, "%s starting" % (name,))
        if random() < hang_chance:
            hung.append(t)
        else:
            running.append(t)
    elif len(running)>0:
        victim = choice(running)
        all_threads.remove(victim)
        running.remove(victim)
        log(t, "%s finished" % (filenames[victim],))