#!/usr/bin/env bash
set -e

description="Add cert to Lucee's keystore."

while :
do
    case $1 in
        --provisioned-dir=*)
            provisioned_dir=${1#*=}        # Delete everything up till "="
            shift
            ;;
        --runfile-name=*)
            runfile_name=${1#*=}        # Delete everything up till "="
            shift
            ;;
        --site-host-name=*)
            site_host_name=${1#*=}        # Delete everything up till "="
            shift
            ;;
        -*)
            echo "WARN: Unknown option (ignored): $1" >&2
            shift
            ;;
        *)  # no more options. Stop while loop
            break
            ;;
    esac
done

runfile="${provisioned_dir}/${runfile_name}"

if [ -f "${runfile}" ]; then
  echo "${description}: Already run."
  exit 0
fi

echo "add cert to keystore"

echo -n | \
  openssl s_client -connect ${site_host_name}:443 \
  | sed -ne '/-BEGIN CERTIFICATE-/,/-END CERTIFICATE-/p' \
  > /tmp/${site_host_name}.cert

/opt/lucee/jdk/jre/bin/keytool \
  -import \
  -keystore /opt/lucee/lib/lucee-server/context/security/cacerts \
  -alias "${site_host_name} (self-signed)" \
  -storepass changeit \
  -file /tmp/${site_host_name}.cert \
  -noprompt \
  || true

touch "${runfile}"