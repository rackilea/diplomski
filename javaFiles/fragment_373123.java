#! python3
import re
import gzip
from lxml import etree

# read the DTD with the lxml parser
dtd = etree.DTD('dblp-2017-08-29.dtd')
# build a dict with it for lookup
replacements = {x.name: x.content for x in dtd.entities()}

entity_re=re.compile('&(\w+);')

def resolve_entity(m):
    """
    This will replace the defined entities with their expansions from the DTD:
    '&Ouml;' will be replaced with '&#214;'.
    The entities that are already escaped with '&#[0-9]+;' should not be expanded,
    Ex: if some of the escapes produced the character '<', the XML would no longer be well formed.

    If the matched entity is not in the replacements, use the match as default
    """
    return replacements.get(m.group(1),f'&{m.group(1)};')

def expand_line(line):
    return entity_re.sub(resolve_entity,line)

def recode_file(src,dst):
    with gzip.open(src,mode='rt', encoding='ISO-8859-1', newline='\n') as src_file:
        # discard first line with wrong encoding
        print('discard: ' + src_file.readline())  
        with gzip.open(dst, mode='wt', encoding='UTF-8', newline='\n') as dst_file:
            # replace with correct encoding statement
            dst_file.write('<?xml version="1.0"?>\n')  
            for line in src_file:
                dst_file.write(expand_line(line))

recode_file('dblp-2018-08-01.xml.gz','dblp_recode.xml.gz')