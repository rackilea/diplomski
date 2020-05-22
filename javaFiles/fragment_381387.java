require 'java'
java.lang.String.public_instance_methods.sort.reject {|m| m =~ /[_?!=~<>]/ }
# => [:bytes, :charAt, :class, :clone, :codePointAt, :codePointBefore, 
# => :codePointCount, :com, :compareTo, :compareToIgnoreCase, :concat, 
# => :contains, :contentEquals, :display, :dup, :empty, :endsWith, :equals, 
# => :equalsIgnoreCase, :extend, :finalize, :freeze, :getBytes, :getChars, 
# => :getClass, :hash, :hashCode, :id, :indexOf, :initialize, :inspect, :intern, 
# => :isEmpty, :java, :javax, :lastIndexOf, :length, :matches, :method, 
# => :methods, :notify, :notifyAll, :offsetByCodePoints, :org, :regionMatches, 
# => :replace, :replaceAll, :replaceFirst, :send, :split, :startsWith, 
# => :subSequence, :substring, :synchronized, :taint, :tap, :toCharArray, 
# => :toLowerCase, :toString, :toUpperCase, :trim, :trust, :type, :untaint, 
# => :untrust, :wait]