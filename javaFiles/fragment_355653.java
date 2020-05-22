public long memoryReader(address) {
    //return memoryReader[address](this, address);
    if (address < 16384) {
        return memoryReadNormal(address);
    } else if (address < 32768) {
        return memoryReadROM(address);
    } else if (address < 38912) {
        return (cGBC) ? VRAMDATAReadCGBCPU(address) : VRAMDATAReadDMGCPU(address);
    } else if (address < 40960) {
        return (cGBC) ? VRAMCHRReadCGBCPU(address) : VRAMCHRReadDMGCPU(address);
    } else if (address >= 40960 && address < 49152) {
        if ((numRAMBanks == 1 / 16 && address < 41472) || numRAMBanks >= 1) {
            if (cMBC7) {
                return memoryReadMBC7(address);
            } else if (!cMBC3) {
                return memoryReadMBC(address);
            } else {
                return memoryReadMBC3(address);
            }
        } else {
            return memoryReadBAD();
        }
    } else if (address >= 49152 && address < 57344) {
        if (!cGBC || address < 53248) {
            return memoryReadNormal(address);
        } else {
            return memoryReadGBCMemory(address);
        }
    } else if (address >= 57344 && address < 65024) {
        if (!cGBC || address < 61440) {
            return memoryReadECHONormal(address);
        } else {
            return memoryReadECHOGBCMemory(address);
        }
    } else if (address < 65184) {
        return memoryReadOAM(address);
    } else if (cGBC && address >= 65184 && address < 65280) {
        return memoryReadNormal(address);
    } else if (address >= 65280) {
        switch (address) {
        case 65280:
            return 192 | memory[65280];
            break;
        case 65281:
            return (memory[65282] < 128) ? memory[65281] : 255;
            break;
        case 65282:
            if (cGBC) {
                return ((serialTimer <= 0) ? 124 : 252) | memory[65282];
            } else {
                return ((serialTimer <= 0) ? 126 : 254) | memory[65282];
            }
            break;
        case 65283:
            return memoryReadBAD();
            break;
        case 65284:
            memory[65284] = (memory[65284] + (DIVTicks >> 8)) & 255;
            DIVTicks &= 255;
            return memory[65284];
            break;
        case 65285:
        case 65286:
            return memoryReadNormal(address);
            break;
        case 65287:
            return 248 | memory[65287];
            break;
        case 65288:
        case 65289:
        case 65290:
        case 65291:
        case 65292:
        case 65293:
        case 65294:
            return memoryReadBAD();
            break;
        case 65295:
            return 224 | interruptsRequested;
            break;
        case 65296:
            return 128 | memory[65296];
            break;
        case 65297:
            return 63 | memory[65297];
            break;
        case 65298:
            return memoryReadNormal(address);
            break;
        case 65299:
            return memoryReadBAD();
            break;
        case 65300:
            return 191 | memory[65300];
            break;
        case 65301:
            return memoryReadBAD();
            break;
        case 65302:
            return 63 | memory[65302];
            break;
        case 65303:
            return memoryReadNormal(address);
            break;
        case 65304:
            return memoryReadBAD();
            break;
        case 65305:
            return 191 | memory[65305];
            break;
        case 65306:
            return 127 | memory[65306];
            break;
        case 65307:
            return memoryReadBAD();
            break;
        case 65308:
            return 159 | memory[65308];
            break;
        case 65309:
            return memoryReadBAD();
            break;
        case 65310:
            return 191 | memory[65310];
            break;
        case 65311:
        case 65312:
            return memoryReadBAD();
            break;
        case 65313:
        case 65314:
            return memoryReadNormal(address);
            break;
        case 65315:
            return 191 | memory[65315];
            break;
        case 65316:
        case 65317:
            return memoryReadNormal(address);
            break;
        case 65318:
            c.audioJIT();
            return 112 | memory[65318];
            break;
        case 65319:
        case 65320:
        case 65321:
        case 65322:
        case 65323:
        case 65324:
        case 65325:
        case 65326:
        case 65327:
            return memoryReadBAD();
            break;
        case 65328:
        case 65329:
        case 65330:
        case 65331:
        case 65332:
        case 65333:
        case 65334:
        case 65335:
        case 65336:
        case 65337:
        case 65338:
        case 65339:
        case 65340:
        case 65341:
        case 65342:
        case 65343:
            return (channel3canPlay) ? memory[65280 | (channel3lastSampleLookup >> 1)] : memory[address];
            break;
        case 65344:
            return memoryReadNormal(address);
            break;
        case 65345:
            return 128 | memory[65345] | modeSTAT;
            break;
        case 65346:
            return backgroundY;
            break;
        case 65347:
            return backgroundX;
            break;
        case 65348:
            return ((LCDisOn) ? memory[65348] : 0);
            break;
        case 65349:
        case 65350:
        case 65351:
        case 65352:
        case 65353:
            return memoryReadNormal(address);
            break;
        case 65354:
            return windowY;
            break;
        case 65355:
            return memoryReadNormal(address);
            break;
        case 65356:
            return memoryReadBAD();
            break;
        case 65357:
            return memoryReadNormal(address);
            break;
        case 65358:
            return memoryReadBAD();
            break;
        case 65359:
            return currVRAMBank;
            break;
        case 65360:
        case 65361:
        case 65362:
        case 65363:
        case 65364:
            return memoryReadNormal(address);
            break;
        case 65365:
            if (cGBC) {
                if (!LCDisOn && hdmaRunning) {
                    DMAWrite((memory[65365] & 127) + 1);
                    memory[65365] = 255;
                    hdmaRunning = false;
                }
                return memory[65365];
            } else {
                return memoryReadNormal(address);
            }
            break;
        case 65366:
            if (cGBC) {
                return 60 | ((memory[65366] >= 192) ? (2 | (memory[65366] & 193)) : (memory[65366] & 195));
            } else {
                return memoryReadNormal(address);
            }
            break;
        case 65367:
        case 65368:
        case 65369:
        case 65370:
        case 65371:
        case 65372:
        case 65373:
        case 65374:
        case 65375:
        case 65376:
        case 65377:
        case 65378:
        case 65379:
        case 65380:
        case 65381:
        case 65382:
        case 65383:
            return memoryReadBAD();
            break;
        case 65384:
        case 65385:
        case 65386:
        case 65387:
            return memoryReadNormal(address);
            break;
        case 65388:
            if (cGBC) {
                return 254 | memory[65388];
            } else {
                return memoryReadBAD();
            }
            break;
        case 65389:
        case 65390:
        case 65391:
            return memoryReadBAD();
            break;
        case 65392:
            if (cGBC) {
                return 64 | memory[65392];
            } else {
                return memoryReadBAD();
            }
            break;
        case 65393:
            return memoryReadBAD();
            break;
        case 65394:
        case 65395:
            return memoryReadNormal(address);
            break;
        case 65396:
            if (cGBC) {
                return memoryReadNormal(address);
            } else {
                return memoryReadBAD();
            }
            break;
        case 65397:
            return 143 | memory[65397];
            break;
        case 65398:
        case 65399:
            return 0;
            break;
        case 65400:
        case 65401:
        case 65402:
        case 65403:
        case 65404:
        case 65405:
        case 65406:
        case 65407:
            return memoryReadBAD();
            break;
        case 65535:
            return interruptsEnabled;
            break;
        default:
            return memoryReadNormal(address);
        }
    } else {
        return memoryReadBAD();
    }
}