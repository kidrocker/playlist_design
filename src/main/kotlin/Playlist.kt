import interfaces.ITrack
import models.Track
import models.User

class Playlist(user: User) : ITrack {

    private val mTrack = mutableSetOf<Track>()

    private var limit: Int = when (user.isPro) {
        true -> 200
        false -> 100
    }

    /**
     * Add a new track to the playlist
     *  @param track Track
     */
    override fun addTrack(track: Track) {
        if (getNumberOfTracks() < limit) {
            mTrack.add(track)
        } else throw Exception("Maximum number of tracks exceeded")
    }

    /**
     * Add multiple tracks to list
     * @param tracks List<Track>
     * @throws Exception
     */
    override fun addTracks(tracks: List<Track>) {
        val totalEstimate = getNumberOfTracks() + tracks.size
        if (totalEstimate <= limit) mTrack.addAll(tracks)
        else throw Exception("Maximum number of tracks exceeded")
    }

    /**
     * Delete single track from the list
     * @param track Track
     * @return void
     */
    override fun deleteTrack(track: Track) {
        mTrack.remove(track)
    }

    /**
     * Delete multiple track from the playlist
     * @param tracks
     * @return void
     */
    override fun deleteTracks(tracks: List<Track>) {
        mTrack.removeAll(tracks)
    }

    /**
     * Get the total duration of the tracks
     * @return Long
     */
    override fun getTotalDuration(): Long {
        return mTrack.sumOf { it.duration }
    }

    /**
     * get the total number of tracks
     * @return Int size of mTrack
     */
    override fun getNumberOfTracks(): Int {
        return mTrack.size
    }

    /**
     * get a track by id
     * @return Track
     */
    override fun getTrack(id: Int): Track? {
        return mTrack.find { it.id == id }
    }

    /**
     * get a list of all tracks
     * @return mTrack
     */
    override fun getAllTracks(): List<Track> {
        return mTrack.toList()
    }
}