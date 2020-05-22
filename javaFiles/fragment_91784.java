package org.objectweb.asm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ConstantPoolSortingClassWriter extends ClassWriter {
    private final int flags;
    Map<Item, Integer> constantHistogram; //initialized by ConstantHistogrammer
    public ConstantPoolSortingClassWriter(int flags) {
        super(flags);
        this.flags = flags;
    }

    @Override
    public byte[] toByteArray() {
        byte[] bytes = super.toByteArray();

        List<Item> cst = new ArrayList<>();
        for (Item i : items)
            for (Item j = i; j != null; j = j.next) {
                //exclude ASM's internal bookkeeping
                if (j.type == TYPE_NORMAL || j.type == TYPE_UNINIT ||
                        j.type == TYPE_MERGED || j.type == BSM)
                    continue;
                if (j.type == CLASS) 
                    j.intVal = 0; //for ASM's InnerClesses tracking
                cst.add(j);
            }

        sortItems(cst);

        ClassWriter target = new ClassWriter(flags);
        //ClassWriter.put is private, so we have to do the insert manually
        //we don't bother resizing the hashtable
        for (int i = 0; i < cst.size(); ++i) {
            Item item = cst.get(i);
            item.index = target.index++;
            if (item.type == LONG || item.type == DOUBLE)
                target.index++;

            int hash = item.hashCode % target.items.length;
            item.next = target.items[hash];
            target.items[hash] = item;
        }

        //because we didn't call newFooItem, we need to manually write pool bytes
        //we can call newFoo to find existing items, though
        for (Item i : cst) {
            if (i.type == UTF8)
                target.pool.putByte(UTF8).putUTF8(i.strVal1);
            if (i.type == CLASS || i.type == MTYPE || i.type == STR)
                target.pool.putByte(i.type).putShort(target.newUTF8(i.strVal1));
            if (i.type == IMETH || i.type == METH || i.type == FIELD)
                target.pool.putByte(i.type).putShort(target.newClass(i.strVal1)).putShort(target.newNameType(i.strVal2, i.strVal3));
            if (i.type == INT || i.type == FLOAT)
                target.pool.putByte(i.type).putInt(i.intVal);
            if (i.type == LONG || i.type == DOUBLE)
                target.pool.putByte(i.type).putLong(i.longVal);
            if (i.type == NAME_TYPE)
                target.pool.putByte(i.type).putShort(target.newUTF8(i.strVal1)).putShort(target.newUTF8(i.strVal2));
            if (i.type >= HANDLE_BASE && i.type < TYPE_NORMAL) {
                int tag = i.type - HANDLE_BASE;
                if (tag <= Opcodes.H_PUTSTATIC)
                    target.pool.putByte(HANDLE).putByte(tag).putShort(target.newField(i.strVal1, i.strVal2, i.strVal3));
                else
                    target.pool.putByte(HANDLE).putByte(tag).putShort(target.newMethod(i.strVal1, i.strVal2, i.strVal3, tag == Opcodes.H_INVOKEINTERFACE));
            }
            if (i.type == INDY)
                target.pool.putByte(INDY).putShort((int)i.longVal).putShort(target.newNameType(i.strVal1, i.strVal2));
        }

        //parse and rewrite with the new ClassWriter, constants presorted
        ClassReader r = new ClassReader(bytes);
        r.accept(target, 0);
        return target.toByteArray();
    }

    private void sortItems(List<Item> items) {
        items.forEach(i -> constantHistogram.putIfAbsent(i, 0));
        //constants appearing more often come first, so we use as few ldc_w as possible
        Collections.sort(items, Comparator.comparing(constantHistogram::get).reversed());
    }
}