@Override
public boolean equals(Object obj) {
    // TODO Auto-generated method stub
    if (this == obj)
        return true;

    if (obj == null || (this.getClass() != obj.getClass())) {
        return false;
    }

    RegionsWithConstituency reg = (RegionsWithConstituency) obj;
    return this.const_name.equals(reg.getConstituencyName())
            && this.reg_name.equals(reg.getRegionName());
}

@Override
public int hashCode() {
    // TODO Auto-generated method stub
    return const_name != null ? const_name.hashCode() : 0;
}