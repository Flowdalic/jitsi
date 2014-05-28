/*
 * Jitsi, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */

package net.java.sip.communicator.service.protocol;

import java.io.*;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackException.NotConnectedException;

/**
 * Used for incoming file transfer request.
 *
 * @author Nicolas Riegel
 * @author Yana Stamcheva
 */
public interface IncomingFileTransferRequest
{
    /**
     * Uniquie ID that is identifying the request and then the FileTransfer
     * if the request has been accepted.
     *
     * @return the id.
     */
    public String getID();

    /**
     * Returns a String that represents the name of the file that is being
     * received.
     * If there is no name, returns null.
     * @return a String that represents the name of the file
     */
    public String getFileName();

    /**
     * Returns a String that represents the description of the file that is
     * being received.
     * If there is no description available, returns null.
     *
     * @return a String that represents the description of the file
     */
    public String getFileDescription();

    /**
     * Returns a long that represents the size of the file that is being
     * received.
     * If there is no file size available, returns null.
     *
     * @return a long that represents the size of the file
     */
    public long getFileSize();

    /**
     * Returns a String that represents the name of the sender of the file
     * being received.
     * If there is no sender name available, returns null.
     *
     * @return a String that represents the name of the sender
     */
    public Contact getSender();

    /**
     * Function called to accept and receive the file.
     *
     * @param file the file to accept
     * @return the <tt>FileTransfer</tt> object managing the transfer
     * @throws SmackException 
     */
    public FileTransfer acceptFile(File file) throws SmackException;

    /**
     * Function called to refuse the file.
     * @throws NotConnectedException 
     */
    public void rejectFile() throws NotConnectedException;

    /**
     * Returns the thumbnail contained in this request.
     *
     * @return the thumbnail contained in this request
     */
    public byte[] getThumbnail();
}
